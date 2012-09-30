dataSource {
    pooled = true
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
            driverClassName = "org.h2.Driver"
            username = "sa"
            password = ""
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    test {
        dataSource {
            driverClassName = "org.h2.Driver"
            username = "sa"
            password = ""
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    production {
        dataSource {
           pooled=true
dbCreate='update'
url='jdbc:mysql://localhost/zeroddbname?useUnicode=yes&characterEncoding=UTF-8'
driverClassName='com.mysql.jdbc.Driver'
dialect='org.hibernate.dialect.MySQL5InnoDBDialect'
username='zerodusername'
password='zerodpassword'
properties {
	maxActive=50
	maxIdle=25
	minIdle=5
	initialSize=5
	minEvictableIdleTimeMillis=60000
	timeBetweenEvictionRunsMillis=60000
	maxWait=10000
	validationQuery='SELECT 1'
}

        }
    }
}
