package com.project._tteockgi.domain.wishlist.Repository;

import com.project._tteockgi.domain.article.entity.Article;
import com.project._tteockgi.domain.wishlist.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    Optional<Wishlist> findByMemberAndArticle(Member member, Article article);

    // 사용자가 찜한 모든 게시글을 가져오는 메서드
    List<Wishlist> findAllByMember(Member member);
}
