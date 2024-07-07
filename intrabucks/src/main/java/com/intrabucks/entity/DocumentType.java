package com.intrabucks.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 문서양식(DocumentType) 엔티티 : 문서양식명, 문서설명, 문서 권한, 문서파일명
 * @author 원치호
 * @version 1.0
 * 2024-06-27
 * **/

@Entity
@Data
@Table(name = "DocumentType")
@NoArgsConstructor
@AllArgsConstructor
public class DocumentType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_type_seq")
    @SequenceGenerator(name = "document_type_seq", sequenceName = "document_type_seq", allocationSize = 1)
    @Column(name = "document_type_id")
    private Long documentTypeId; // 문서 양식 ID

    @Column(name = "document_type_name")
    private String documentTypeName; // 문서 양식 이름

    
    @Column(name = "document_type_content")
    @Lob // 추가
    private String documentTypeContent; // 문서내용

    @Column(name = "document_authority")
    private String documentAuthority; // 권한

    @Column(name = "document_form_name")
    private String documentFormName; // 첨부 양식

}