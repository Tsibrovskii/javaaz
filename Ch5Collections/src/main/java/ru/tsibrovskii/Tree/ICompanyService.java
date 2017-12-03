package ru.tsibrovskii.Tree;

import java.util.List;

/**
 * Интерфейс поиска.
 */
public interface ICompanyService {

    /**
     * @param child - company for whom we are searching the top
     * level parent (parent of parent of...)
     * @return top level parent
     */
    Company getTopLevelParent(Company child);

    /**
     * @param company - company for whom we are searching count of employees
     * (count of this company employees +
     * count of employees for all children companies and their children, etc.)
     * @param companies - all available companies
     * @return count of employees
     */
    long getEmployeeCountForCompanyAndChildren(Company company, List<Company> companies);
}
