/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fitnessgym.controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.fitnessgym.dao.GenericDAO;
import org.fitnessgym.dao.LinkDAO;
import org.fitnessgym.model.Link;

/**
 *
 * @author vu
 */
@ManagedBean
@RequestScoped
public class LinksController extends GenericController<Link> implements java.io.Serializable {    
    
    private int linkId;
    private String linkUrl;
    private List<Link> list;
    
    
    
    
    public void addLink(){
        GenericDAO<Link> linkDAO = new LinkDAO();
        Link link=new Link();
        link.setLinkUrl(linkUrl);
        linkDAO.add(link);
        getList();
        linkUrl="";
    }

    public List<Link> getList() {
        GenericDAO<Link> linkDAO = new LinkDAO();
        list = linkDAO.getList("From Link");
        TOTAL_ROWS = list.size();
        return list;
    }

    public int getLinkId() {
        return linkId;
    }

    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }
    
    
    
    
    
    
    
}
