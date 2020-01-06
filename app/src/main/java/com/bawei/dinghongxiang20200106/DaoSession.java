package com.bawei.dinghongxiang20200106;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.bawei.dinghongxiang20200106.entity.GreenEntity;

import com.bawei.dinghongxiang20200106.GreenEntityDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig greenEntityDaoConfig;

    private final GreenEntityDao greenEntityDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        greenEntityDaoConfig = daoConfigMap.get(GreenEntityDao.class).clone();
        greenEntityDaoConfig.initIdentityScope(type);

        greenEntityDao = new GreenEntityDao(greenEntityDaoConfig, this);

        registerDao(GreenEntity.class, greenEntityDao);
    }
    
    public void clear() {
        greenEntityDaoConfig.clearIdentityScope();
    }

    public GreenEntityDao getGreenEntityDao() {
        return greenEntityDao;
    }

}
