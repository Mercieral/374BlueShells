package problem.javaClasses;

import problem.interfaces.IRelation;
import problem.visitor.IVisitor;

public class HasRelation implements IRelation {
	
	private String start;

	private String end;

	private String details;

	private final String ARROW = " -> ";

	@Override
	public boolean equals(Object obj) {
		IRelation inObj = (IRelation)obj;
		if(!start.equals(inObj.getFromObject()) || !end.equals(inObj.getToObject()) || !this.drawRelation().equals(inObj.drawRelation())){
			return false;
		}
		return true;
	}

	/**
	 * Arrow to represent to association
	 */
	public HasRelation() {
		this.start = "";
		this.end = "";
		this.details = "\n\t\t[arrowhead=\"vee\"];\n";
	}
	
	public String drawRelation() {
		StringBuilder sb = new StringBuilder();
		sb.append("\t");
		sb.append(this.start);
		sb.append(ARROW);
		sb.append(this.end);
		sb.append(this.details);
		return sb.toString();
	}

	@Override
	public void setFromObject(String startObject) {
		this.start = startObject.replace("/", "");
	}

	@Override
	public void setToObject(String endObject) {
		this.end = endObject.replace("/", "");
	}

	@Override
	public String getFromObject() {
		return this.start;
	}

	@Override
	public String getToObject() {
		return this.end;
	}
	
	@Override
	public void accept(IVisitor v) {
		v.preVisit(this);
		v.visit(this);
		v.postVisit(this);
	}

}
