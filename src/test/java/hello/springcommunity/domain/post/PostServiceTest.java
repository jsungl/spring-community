package hello.springcommunity.domain.post;

import hello.springcommunity.domain.member.Member;
import hello.springcommunity.web.post.form.PostUpdateForm;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@Slf4j
@SpringBootTest
@Transactional
class PostServiceTest {

    @Autowired
    PostService postService;
    @Autowired
    EntityManager em;

    @Test
    void save() {

        //given
        Member member = Member.builder().loginId("userA").name("aaa").password("123123a!").build();
        em.persist(member);

        //when
        Post savedPost = postService.save("AAA", "BBB", member.getId());

        //then
        //Post post = postRepository.findById(savedPost.getId()).orElseThrow();
        Post post = postService.findOne(savedPost.getId()).orElseThrow();

        assertThat(post.getTitle()).isEqualTo("AAA");
        assertThat(post.getContent()).isEqualTo("BBB");
        assertThat(post.getMember()).isEqualTo(member);
    }

    @Test
    void update() {

        //given
        Member member = Member.builder().loginId("userA").name("aaa").password("123123a!").build();
        em.persist(member);
        Post savedPost = postService.save("AAA", "BBB", member.getId());
        PostUpdateForm updateForm = new PostUpdateForm();
        updateForm.setTitle("CCC");
        updateForm.setContent("DDD");

        //when
        postService.update(savedPost.getId(), updateForm);

        //then
        Post post = postService.findOne(savedPost.getId()).orElseThrow();

        assertThat(post.getTitle()).isEqualTo("CCC");
        assertThat(post.getContent()).isEqualTo("DDD");
        assertThat(post.getMember()).isEqualTo(member);

    }

    @Test
    void findPosts() {

        //given
//        List<Member> members = em.createQuery("select m from Member m where m.loginId = :loginId", Member.class)
//                .setParameter("loginId", "test")
//                .getResultList();
//        Optional<Member> member = members.stream().findAny();
//
//        log.info("member={}", member.get());

//        List<Post> result = postService.findPostBySearch(new PostSearchCond("검색", null, "test"));
//        for (Post post : result) {
//            log.info("result={}", post.getTitle());
//        }

    }

//    void test(String title, String content, String loginId, Post... posts) {
//        List<Post> result = postService.findPostsBySearch(new PostSearchCond(title, content, loginId));
//        assertThat(result).containsExactly(posts);
//    }


}