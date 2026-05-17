package com.surshree.app.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="T_FILE_CONTENT")
public class FileContentEntity extends BaseEntity{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Type(type="pg-uuid")
    @Column(name = "FILE_ID")
    private UUID fileContentId;

    @Column(name = "FILE_NAME")
    private String fileName;

    @Column(name = "FILE_TYPE")
    private String fileType;

    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    @Column(name = "FILE_DATA")
    @Basic(fetch=FetchType.LAZY)
    private byte[] fileData;
}
