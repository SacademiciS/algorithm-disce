package behavioral.medium.design.dao;

import behavioral.medium.design.po.School;

public interface ISchoolDao {

    School querySchoolInfoById(Long treeId);

}
