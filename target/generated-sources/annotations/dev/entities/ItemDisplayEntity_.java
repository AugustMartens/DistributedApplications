package dev.entities;

import dev.entities.ItemEntity;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-06-23T11:26:19", comments="EclipseLink-2.7.4.v20190115-rNA")
@StaticMetamodel(ItemDisplayEntity.class)
public class ItemDisplayEntity_ { 

    public static volatile SingularAttribute<ItemDisplayEntity, String> imagePath;
    public static volatile SingularAttribute<ItemDisplayEntity, Long> itemDisplayId;
    public static volatile ListAttribute<ItemDisplayEntity, ItemEntity> items;

}