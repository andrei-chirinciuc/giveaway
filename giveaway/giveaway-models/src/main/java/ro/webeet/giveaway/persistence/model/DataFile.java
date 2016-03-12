package ro.webeet.giveaway.persistence.model;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import ro.webeet.giveaway.persistence.model.property.EntityTemplate;

@Entity
public class DataFile extends DBModel{

	private static final long serialVersionUID = 2474813637569046977L;

	@Id
	@GeneratedValue
	private Long id;
	private String fileName;
	private String fileType;
	private String fileSize;
	@Lob
	private Blob content;
	private Boolean indexable;
	private Long entityId;
	@Enumerated
	private EntityTemplate entityName;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public Boolean getIndexable() {
		return indexable;
	}
	public void setIndexable(Boolean indexable) {
		this.indexable = indexable;
	}

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	public EntityTemplate getEntityName() {
		return entityName;
	}

	public void setEntityName(EntityTemplate entityName) {
		this.entityName = entityName;
	}

	public Blob getContent() {
		return content;
	}

	public void setContent(Blob content) {
		this.content = content;
	}

}
