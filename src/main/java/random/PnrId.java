package random;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class PnrId implements Serializable{
  private static final long serialVersionUID = -1L;

  protected String recLoc;

  protected Date creDate;

  public PnrId() {
  }

  public PnrId(String id, Date createDate) {
    this.recLoc = id;
    this.creDate = createDate;
  }

  public String getRecLoc() {
    return this.recLoc;
  }

  public void setRecLoc(String value) {
    this.recLoc = value;
  }

  public Date getCreDate() {
    return this.creDate;
  }

  public void setCreDate(Date value) {
    this.creDate = value;
  }

  public int hashCode() {
    int result = 1;
     result = 31 * result + (this.creDate == null ? 0 : this.creDate.hashCode());
    result = 31 * result + (this.recLoc == null ? 0 : this.recLoc.hashCode());
    return result;
  }

  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    } else if (obj == null) {
      return false;
    } else if (this.getClass() != obj.getClass()) {
      return false;
    } else {
      PnrId other = (PnrId)obj;
      if (this.recLoc == null) {
        if (other.recLoc != null) {
          return false;
        }
      } else if (this.creDate == null) {
        if (other.creDate != null) {
          return false;
        }
      } else if (!this.creDate.equals(other.creDate)) {
        return false;
      }

      return this.recLoc.equals(other.recLoc);
    }
  }

  public String toString() {
    return "PnrId [" + this.recLoc + " , " + this.creDate + "]";
  }

  public static void main(String[] args) {
    Set<PnrId> keySet = new TreeSet<>();
    for (int i = 0; i <10; i++) {
      keySet.add(new PnrId(i+"", new Date()));
    }
  }

//  @Override
//  public int compareTo(PnrId pnrId) {
//    return this.recLoc.compareTo(pnrId.getRecLoc());
//  }
}