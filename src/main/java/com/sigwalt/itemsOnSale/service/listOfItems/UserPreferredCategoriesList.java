package com.sigwalt.itemsOnSale.service.listOfItems;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sigwalt.itemsOnSale.dto.ItemDto;
import com.sigwalt.itemsOnSale.repository.IItemRepository;

public class UserPreferredCategoriesList implements ListOfItemsToBeRetrieved {

	@Override
	public Page<ItemDto> execute(long userId, IItemRepository itemRepo, Pageable pagination) {
		return ItemDto.convert(itemRepo.getItemsByCategoryByOrderByUser(userId, pagination));
	}

}
