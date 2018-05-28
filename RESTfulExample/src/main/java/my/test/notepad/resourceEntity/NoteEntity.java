package my.test.notepad.resourceEntity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


public class NoteEntity {

	@JsonProperty("note")
	private String note;
	
	@JsonProperty("noteId")
	private long noteId;
	
	@JsonProperty("noteBookId")
	private long noteBookId;
	
	@JsonProperty("note_user_id")
	private int noteUserId;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ssz")
	@JsonProperty("createDate")
	private Date createDate;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ssz")
	@JsonProperty("updateDate")
	private Date updateDate;

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public long getNoteId() {
		return noteId;
	}

	public void setNoteId(long noteId) {
		this.noteId = noteId;
	}

	public long getNoteBookId() {
		return noteBookId;
	}

	public void setNoteBookId(long noteBookId) {
		this.noteBookId = noteBookId;
	}

	public int getNoteUserId() {
		return noteUserId;
	}

	public void setNoteUserId(int noteUserId) {
		this.noteUserId = noteUserId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "NoteEntity [note=" + note + ", noteId=" + noteId + ", noteBookId=" + noteBookId + ", noteUserId="
				+ noteUserId + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	

}
