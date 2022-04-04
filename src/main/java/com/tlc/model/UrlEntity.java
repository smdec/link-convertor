package com.tlc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Entity that describes stored converted web url and deep links
 */
@Entity
@Table(name = "url")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "url")
    private String url;
    @Column(name = "deepLink")
    private String deepLink;
}
