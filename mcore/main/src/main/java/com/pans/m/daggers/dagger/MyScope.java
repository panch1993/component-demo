package com.pans.m.daggers.dagger;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

/**
 * @author Pan
 * @DATE 2021/8/18.
 * @TIME 21:54.
 */
@Scope
@Documented
@Retention(RUNTIME)
@interface MyScope {
}
