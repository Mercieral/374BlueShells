package problem.javaClasses;

import problem.interfaces.IRelation;
import problem.visitor.IVisitor;

public class DecorateRelation implements IRelation {

	private String start;

	private String end;

	private String details;

	private final String ARROW = " -> ";

	private String label;

	public DecorateRelation() {
		this.start = "";
		this.end = "";
		this.label = "label=\"<<decorates>>\"";
		this.details = "\n\t\t[arrowhead=\"vee\", " + this.label + "];\n";
	}

	@Override
	public void accept(IVisitor v) {
		v.preVisit(this);
		v.visit(this);
		v.postVisit(this);

	}

	@Override
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

}
