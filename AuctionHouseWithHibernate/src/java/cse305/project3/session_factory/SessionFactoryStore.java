/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse305.project3.session_factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author tomw
 */
public class SessionFactoryStore {

    private static SessionFactoryStore sessionFactoryStore=null;

    private SessionFactory sessionFactory = null;

    private SessionFactoryStore(){

    }
    /**
     * access to data is given by PsSessionFactory method
     * @return
     */
    public static SessionFactoryStore getSessionFactoryStore(){
        if(sessionFactoryStore==null){
            sessionFactoryStore=new SessionFactoryStore();
        }
        return sessionFactoryStore;
    }

    /**
     * get the sessionFactory, make sure that only one exists
     * @return
     */
    public SessionFactory getSessionFactory(){
        if(sessionFactory==null){
            sessionFactory =  new AnnotationConfiguration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }


} 