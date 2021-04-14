package com.sigwalt.itemsOnSale.service.listOfItems;

import java.util.List;

import com.sigwalt.itemsOnSale.dto.ItemDto;
import com.sigwalt.itemsOnSale.repository.IItemRepository;

public class UserPreferredCategoriesList implements ListOfItemsToBeRetrieved {

	@Override
	public List<ItemDto> execute(long userId, IItemRepository itemRepo) {
		return ItemDto.convert(itemRepo.getItemsByCategoryByOrderByUser(userId));
	}

}
