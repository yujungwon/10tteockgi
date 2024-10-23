package com.project._tteockgi.domain.wishlist.service;

import com.project._tteockgi.domain.article.entity.Article;
import com.project._tteockgi.domain.article.service.ArticleService;
import com.project._tteockgi.domain.member.entity.Member;
import com.project._tteockgi.domain.member.service.MemberService;
import com.project._tteockgi.domain.wishlist.Repository.WishlistRepository;
import com.project._tteockgi.domain.wishlist.entity.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;
    private final ArticleService articleService;
    private final MemberService memberService;

    @Autowired
    public WishlistService(WishlistRepository wishlistRepository, ArticleService articleService, MemberService memberService) {
        this.wishlistRepository = wishlistRepository;
        this.articleService = articleService;
        this.memberService = memberService;
    }

    // 찜 추가
    public void addToWishlist(Long memberId, Long articleId) {
        Member member = memberService.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid member ID"));
        Article article = articleService.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid article ID"));

        // 이미 찜한 게시글인지 확인
        if (wishlistRepository.findByMemberAndArticle(member, article).isPresent()) {
            throw new IllegalArgumentException("This article is already in your wishlist");
        }

        Wishlist wishlist = new Wishlist(member, article);
        wishlistRepository.save(wishlist);
    }

    // 찜 삭제
    public void removeFromWishlist(Long memberId, Long articleId) {
        Member member = memberService.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid member ID"));
        Article article = articleService.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid article ID"));

        Wishlist wishlist = wishlistRepository.findByMemberAndArticle(member, article)
                .orElseThrow(() -> new IllegalArgumentException("Wishlist item not found"));

        wishlistRepository.delete(wishlist);
    }

    // 사용자가 찜한 모든 게시글 조회
    public List<Wishlist> getWishlistByMember(Long memberId) {
        Member member = memberService.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid member ID"));
        return wishlistRepository.findAllByMember(member);
    }
}
