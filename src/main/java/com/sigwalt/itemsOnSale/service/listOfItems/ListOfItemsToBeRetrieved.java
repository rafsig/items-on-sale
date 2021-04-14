package com.sigwalt.itemsOnSale.service.listOfItems;

import java.util.List;

import com.sigwalt.itemsOnSale.dto.ItemDto;
import com.sigwalt.itemsOnSale.repository.IItemRepository;

public interface ListOfItemsToBeRetrieved {

	List<ItemDto> execute(long userId, IItemRepository itemRpo);
}
