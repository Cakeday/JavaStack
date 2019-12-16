package com.sample.plate.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="magazines")
public class Magazine {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer pages;
    
    @OneToMany(mappedBy="sponsor", fetch = FetchType.LAZY)
    private List<User> coverModels;
    
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "magazines_advertisements", 
        joinColumns = @JoinColumn(name = "magazine_id"), 
        inverseJoinColumns = @JoinColumn(name = "advertisement_id")
    )
    private List<Advertisement> advertisements;
    
    public Magazine() {
    	
    }
    
    
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public List<User> getCoverModels() {
		return coverModels;
	}
	public void setCoverModels(List<User> coverModels) {
		this.coverModels = coverModels;
	}
	public List<Advertisement> getAdvertisements() {
		return advertisements;
	}
	public void setAdvertisements(List<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
