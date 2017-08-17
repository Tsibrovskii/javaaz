package ru.tsibrovskii.CollectionFramework.AdditionalTask;

import org.junit.Test;
import ru.tsibrovskii.CollectionsFramework.AdditionalTask.SortDepartments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестовый класс.
 */
public class SortDepartmentsTest {

    /**
     * Тестовый метод.
     */
    @Test
    public void whenGiveListOfDepartmentsShouldReturnFullList() {

        SortDepartments sortDepartment = new SortDepartments();

        List<String> departmentsList = new ArrayList<>();
        departmentsList.addAll(Arrays.asList("K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2",
                "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"));

        List<String> departmentsListResult = new ArrayList<>();
        departmentsListResult.addAll(Arrays.asList("K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2",
                "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2", "K1", "K2\\SK1"));
        sortDepartment.addParentDepartments(departmentsList);

        assertThat(departmentsList, is(departmentsListResult));
    }

    /**
     * Тестовый метод сортировки по возрастанию.
     */
    @Test
    public void whenGiveListOfDepartmentsShouldReturnSortedListAsc() {
        SortDepartments sortDepartment = new SortDepartments();

        List<String> departmentsList = new ArrayList<>();
        departmentsList.addAll(Arrays.asList("K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2",
                "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"));

        List<String> departmentsListResult = new ArrayList<>();
        departmentsListResult.addAll(Arrays.asList("K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK2",
                "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"));
        sortDepartment.addParentDepartments(departmentsList);
        sortDepartment.sortDepartmentAsc(departmentsList);

        assertThat(departmentsList, is(departmentsListResult));
    }

    /**
     * Тестовый метод сортировки по убыванию.
     */
    @Test
    public void whenGiveListOfDepartmentsShouldReturnSortedListDesc() {
        SortDepartments sortDepartment = new SortDepartments();

        List<String> departmentsList = new ArrayList<>();
        departmentsList.addAll(Arrays.asList("K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2",
                "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"));

        List<String> departmentsListResult = new ArrayList<>();
        departmentsListResult.addAll(Arrays.asList("K2", "K2\\SK1", "K2\\SK1\\SSK2", "K2\\SK1\\SSK1",
                "K1", "K1\\SK2", "K1\\SK1", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1"));
        sortDepartment.addParentDepartments(departmentsList);
        sortDepartment.sortDepartmentDesc(departmentsList);

        assertThat(departmentsList, is(departmentsListResult));
    }
}
