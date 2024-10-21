package com.project._tteockgi.domain.wishlist.service;

import com.project._tteockgi.domain.wishlist.Repository.WishListRepository;
import com.project._tteockgi.domain.wishlist.entity.WishList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListService {

    private final WishListRepository wishListRepository;

    public WishListService(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    public List<WishList> getWishlistByMemberId(Long memberId) {
        return WishListRepository.findByMemberId(memberId);
    }

}
