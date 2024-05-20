package ru.t1.owner.service;

import ru.t1.owner.dto.NewOwnerDto;
import ru.t1.owner.dto.OwnerDto;
import ru.t1.owner.dto.UpdateOwnerDto;

import java.util.Collection;

public interface OwnerService {
    /**
     * Добавление владельца продукта
     *
     * @param ownerDto данные о новом владельце продукта
     * @return dto добавленного владельца продукта
     */
    OwnerDto addOwner(NewOwnerDto ownerDto);

    /**
     * Получение информации о владельце продукта по id
     *
     * @param ownerId id запрашиваемого владельца продукта
     * @return dto запрашиваемого владельца продукта
     */
    OwnerDto getOwnerById(Long ownerId);

    /**
     * Обновить данные о владельце продукта
     *
     * @param ownerId id обновляемого владельца продукта
     * @param updateOwnerDto dto с данным для обновления информации о владельце продукта
     * @return dto обновлённого владельца продукта
     */
    OwnerDto updateOwner(Long ownerId, UpdateOwnerDto updateOwnerDto);

    /**
     * Получение перечня всех владельцев продуктов
     *
     * @return список dto всех владельцев продуктов
     */
    Collection<OwnerDto> getAllOwners();

    /**
     * Удаление владельца продукта по id
     *
     * @param ownerId id удаляемого владельца продукта
     */
    void deleteOwnerById(Long ownerId);
}
