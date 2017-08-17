package ru.tsibrovskii.CollectionsFramework.AdditionalTask;

import java.util.*;

/**
 * Класс сортировки департаментов.
 */
public class SortDepartments {

    /**
     * Метод добавления в лист департаментов недостающих родительских департаментов.
     * @param departmentList лист департаментов.
     */
    public void addParentDepartments(List<String> departmentList) {

        List<String> sortList = new ArrayList<>();
        sortList.addAll(departmentList);
        for(String sort : sortList) {
            while (sort.contains("\\")) {
                sort = sort.substring(0, sort.lastIndexOf("\\"));
                if(!departmentList.contains(sort)) {
                    departmentList.add(sort);
                }
            }
        }
    }

    /**
     * Метод сортировки департаментов по возрастанию.
     * @param departmentList лист департаментов.
     */
    public void sortDepartmentAsc(List<String> departmentList) {
        addParentDepartments(departmentList);
        departmentList.sort(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                }
        );
    }

    /**
     * Метод сортировки департаментов по убыванию.
     * @param departmentList лист департаментов.
     */
    public void sortDepartmentDesc(List<String> departmentList) {
        addParentDepartments(departmentList);
        departmentList.sort(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        if(o1.startsWith(o2)) {
                            return 1;
                        } else if(o2.startsWith(o1)) {
                            return -1;
                        } else {
                            return o2.compareTo(o1);
                        }
                    }
                }
        );
    }
}
