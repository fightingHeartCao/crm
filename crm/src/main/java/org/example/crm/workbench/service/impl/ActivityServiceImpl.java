package org.example.crm.workbench.service.impl;

import org.example.crm.utils.SqlSessionUtil;
import org.example.crm.workbench.dao.ActivityDao;
import org.example.crm.workbench.service.ActivityService;

public class ActivityServiceImpl implements ActivityService {
    private ActivityDao activityDao = SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);


}
