package com.project._tteockgi;

import com.project._tteockgi.domain.article.service.ArticleService;
import com.project._tteockgi.domain.auction.service.AuctionService;
import com.project._tteockgi.domain.member.entity.Member;
import com.project._tteockgi.domain.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
	@Autowired
	ArticleService articleService;
	@Autowired
	AuctionService auctionService;
	@Autowired
	MemberService memberService;

	@Test
	void contextLoads() {
		Member member = memberService.create("test", "test", "test@test.com", "1234");
		for (int i = 0; i <= 10; i++) {
			articleService.create("제목" + i, "내용" + i, member);
		}
	}

}
