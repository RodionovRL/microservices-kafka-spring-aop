package ru.t1.solution.service;

import ru.t1.solution.dto.NewSolutionDto;
import ru.t1.solution.dto.SolutionDto;
import ru.t1.solution.dto.UpdateSolutionDto;

import java.util.Collection;

public interface SolutionService {
    /**
     * Добавление продукта
     *
     * @param solutionDto данные о новом продукте
     * @return dto добавленного продукта
     */
    SolutionDto addSolution(NewSolutionDto solutionDto);

    /**
     * Получение информации о продукте по id
     *
     * @param solutionId id запрашиваемого продукта
     * @return dto запрашиваемого продукта
     */
    SolutionDto getSolutionById(Long solutionId);

    /**
     * Обновить данные о продукте
     *
     * @param solutionId id обновляемого продукта
     * @param updateSolutionDto dto с данным для обновления информации о продукте
     * @return dto обновлённого продукта
     */
    SolutionDto updateSolution(Long solutionId, UpdateSolutionDto updateSolutionDto);

    /**
     * Получение перечня всех продуктов
     *
     * @return список dto всех продуктов
     */
    Collection<SolutionDto> getAllSolutions();

    /**
     * Удаление продукта по id
     *
     * @param solutionId id удаляемого продукта
     */
    void deleteSolutionById(Long solutionId);
}
