package com.imooc.reader.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imooc.reader.entity.Evaluation;
import com.imooc.reader.entity.Member;
import com.imooc.reader.entity.MemberReadState;
import com.imooc.reader.mapper.EvaluationMapper;
import com.imooc.reader.mapper.MemberMapper;
import com.imooc.reader.mapper.MemberReadStateMapper;
import com.imooc.reader.service.MemberService;
import com.imooc.reader.service.exception.BussinessException;
import com.imooc.reader.utils.MD5Utils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 开发流程：
 * -> entity.MemberReadState 创建实体类，对应数据库表
 * -> mapper.MemberReadStateMapper 创建crud工具，继承了BaseMapper
 * -> mapper.member_read_state.xml
 * -> service.MemberService、service.MemberServiceImpl  具体使用crud方法实现业务逻辑增删改查
 * -> controller.MemberController 产生前端需要后端提供的数据，与前端交互，这里不再进行后端复杂的逻辑计算，计算都放在service里
 * -> web : detail.ftl
 */
@Service("memberService")
@Transactional
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberMapper memberMapper;

    @Resource
    private MemberReadStateMapper memberReadStateMapper;

    @Resource
    private EvaluationMapper evaluationMapper;

    /**
     * 会员注册,创建新会员
     *
     * @param username 用户名
     * @param password 密码
     * @param nickname 昵称
     * @return 新会员对象
     */
    public Member createMember(String username, String password, String nickname) {

        // 判断用户名是否已存在，存在的话就告诉用户用户名已存在
        QueryWrapper<Member> queryWrapper = new QueryWrapper<Member>();
        queryWrapper.eq("username", username);
        List<Member> members = memberMapper.selectList(queryWrapper);
        if (members.size() > 0) {
            throw new BussinessException("M01", "用户名已存在");
        }

        // 用户输入的username是新的，可以创建新用户
        Member member = new Member();
        member.setUsername(username);
        member.setNickname(nickname);
        member.setCreateTime(new Date());

        // 用户输入的password不能明文存储在数据库，使用MD5加密后再存储
        int salt = new Random().nextInt(1000) + 1000;
        String md5Digest = MD5Utils.md5Digest(password, salt);

        member.setPassword(md5Digest);
        member.setSalt(salt);
        memberMapper.insert(member);
        return member;
    }

    /**
     * 登录检查
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录对象
     * BussinessException("M01", "用户名已存在")
     * BussinessException("M02","用户不存在")
     * BussinessException("M03","输入密码有误")
     * code=0, success
     */
    public Member checkLogin(String username, String password) {
        // 数据库用户username具有唯一性，如果找不到这个username，要么是没注册要么是username拼写有误
        QueryWrapper<Member> queryWrapper = new QueryWrapper<Member>();
        queryWrapper.eq("username", username);
        Member member = memberMapper.selectOne(queryWrapper);
        if (member == null) {
            throw new BussinessException("M02", "用户不存在");
        }
        String md5Digest = MD5Utils.md5Digest(password, member.getSalt());
        if (!md5Digest.equals(member.getPassword())) {
            throw new BussinessException("M03", "输入密码有误");
        }
        return member;
    }

    /**
     * 获取阅读状态
     *
     * @param memberId 会员编号
     * @param bookId   图书编号
     * @return 阅读状态对象
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public MemberReadState selectMemberReadState(Long memberId, Long bookId) {
        QueryWrapper<MemberReadState> queryWrapper = new QueryWrapper<MemberReadState>();
        queryWrapper.eq("member_id", memberId);
        queryWrapper.eq("book_id", bookId);
        MemberReadState memberReadState = memberReadStateMapper.selectOne(queryWrapper);
        return memberReadState;
    }

    /**
     * 更新阅读状态
     *
     * @param memberId  会员编号
     * @param bookId    图书编号
     * @param readState 阅读状态
     * @return 阅读状态对象
     */
    public MemberReadState updateMemberReadState(Long memberId, Long bookId, Integer readState) {
        QueryWrapper<MemberReadState> queryWrapper = new QueryWrapper<MemberReadState>();
        queryWrapper.eq("book_id", bookId);
        queryWrapper.eq("member_id", memberId);
        MemberReadState memberReadState = memberReadStateMapper.selectOne(queryWrapper);
        //无则新增,有则更新
        if (memberReadState == null) {
            memberReadState = new MemberReadState();
            memberReadState.setMemberId(memberId);
            memberReadState.setBookId(bookId);
            memberReadState.setReadState(readState);
            memberReadState.setCreateTime(new Date());
            memberReadStateMapper.insert(memberReadState);
        } else {
            memberReadState.setReadState(readState);
            memberReadStateMapper.updateById(memberReadState);
        }

        return memberReadState;
    }

    /**
     * 发布新的短评
     *
     * @param memberId 会员编号
     * @param bookId   图书编号
     * @param score    评分
     * @param content  短评内容
     * @return 短评对象
     */
    public Evaluation evaluate(Long memberId, Long bookId, Integer score, String content) {
        Evaluation evaluation = new Evaluation();
        evaluation.setMemberId(memberId);
        evaluation.setBookId(bookId);
        evaluation.setScore(score);
        evaluation.setContent(content);
        evaluation.setCreateTime(new Date());
        evaluation.setState("enable");
        evaluation.setEnjoy(0);
        evaluationMapper.insert(evaluation);
        return evaluation;
    }

    /**
     * 短评点赞
     *
     * @param evaluationId 短评编号
     * @return 短评对象
     */
    public Evaluation enjoy(Long evaluationId) {
        Evaluation evaluation = evaluationMapper.selectById(evaluationId);
        evaluation.setEnjoy(evaluation.getEnjoy()+1);
        evaluationMapper.updateById(evaluation);
        return evaluation;
    }

}
