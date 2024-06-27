package com.intrabucks.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 문서양 식(DocumentTypes) 엔티티 : 문서양식명, 문서설명, 문서 권한, 문서파일명
 * @author 원치호
 * @version 1.0
 * 2024-06-27
 * **/

@Entity
@Data
@Table(name = "DocumentTypes")
@NoArgsConstructor
@AllArgsConstructor
public class DocumentType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_type_seq")
    @SequenceGenerator(name = "document_type_seq", sequenceName = "document_type_seq", allocationSize = 1)
    @Column(name = "document_type_id")
    private Long documentTypeId;

    @Column(name = "document_type_name", length = 100)
    private String documentTypeName;

    @Column(name = "document_type_content", length = 255)
    private String documentTypeContent;

    @Column(name = "document_authority", length = 255)
    private String documentAuthority;

    @Column(name = "document_form_name", length = 100)
    private String documentFormName;

}