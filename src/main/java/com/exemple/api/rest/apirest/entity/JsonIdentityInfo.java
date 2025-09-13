package com.exemple.api.rest.apirest.entity;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

public @interface JsonIdentityInfo {
    Class<ObjectIdGenerators.PropertyGenerator> generator();

    String property();
}
