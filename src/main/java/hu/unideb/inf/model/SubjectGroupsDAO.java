package hu.unideb.inf.model;

import java.util.List;

public interface SubjectGroupsDAO extends AutoCloseable{
        public void saveSubjectGroup(SubjectGroups a);
        public void deleteSubjectGroup(SubjectGroups a);
        public void updateSubjectGroup(SubjectGroups a);
        public List<SubjectGroups> getSubjectGroup();
    }
