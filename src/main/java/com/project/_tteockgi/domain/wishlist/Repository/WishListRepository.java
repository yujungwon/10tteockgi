package com.project._tteockgi.domain.wishlist.Repository;

import com.project._tteockgi.domain.wishlist.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Long> {
    static List<WishList> findByMemberId(Long memberId) {
        return null;
    }
}
