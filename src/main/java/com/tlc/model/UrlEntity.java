package com.tlc.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Entity that describes stored converted web url and deep links
 */
@Entity
@Table(name = "url")
@Data
public class UrlEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "url")
    private String url;
    @Column(name = "deepLink")
    private String deepLink;
}
