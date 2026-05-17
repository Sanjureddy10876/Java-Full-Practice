package kodewala.junit_sample.repo.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author : zhangqian9158@gmail.com
 */
@Component
public class ThinkMetaObjectHandler implements MetaObjectHandler {

    private static final String CREATE_TIME = "createTime";

    private static final String UPDATE_TIME = "updateTime";

    private static final String DELETED = "deleted";

    @Override
    public void insertFill(MetaObject metaObject) {

        boolean hasCreateTime = metaObject.hasSetter(CREATE_TIME);
        boolean hasUpdateTime = metaObject.hasSetter(UPDATE_TIME);
        boolean hasDeleted = metaObject.hasSetter(DELETED);
        if (hasCreateTime) {
            strictInsertFill(metaObject, CREATE_TIME, LocalDateTime.class,
                    LocalDateTime.now());
        }
        if (hasUpdateTime) {
            strictInsertFill(metaObject, UPDATE_TIME, LocalDateTime.class,
                    LocalDateTime.now());
        }
        if (hasDeleted) {
            strictInsertFill(metaObject, DELETED, Boolean.class, false);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        strictUpdateFill(metaObject, UPDATE_TIME, LocalDateTime.class,
                LocalDateTime.now());
    }

}
