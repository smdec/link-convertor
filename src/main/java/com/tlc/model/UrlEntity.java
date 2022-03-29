package com.tlc.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "url")
@Data
public class UrlEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private String deepLink;
}
