package project.asm;

import java.util.List;

import org.objectweb.asm.MethodVisitor;

import project.interfaces.IClass;
import project.interfaces.IMethod;
import project.interfaces.IModel;
import project.interfaces.IRelation;
import project.javaClasses.MethodContainer;
import project.javaClasses.UsesRelation;

public class MyMethodVisitor extends MethodVisitor {
	private IClass currentClass;
	private List<String> classes;
	private IMethod currentMethod;
	private IModel model;

	public MyMethodVisitor(int api, MethodVisitor mv, IClass currentClass,
			List<String> classes, IMethod currentMethod, IModel m) {
		super(api, mv);
		this.currentClass = currentClass;
		this.classes = classes;
		this.currentMethod = currentMethod;
		this.model = m;

	}

	@Override
	public void visitMethodInsn(int opcode, String owner, String name,
			String desc, boolean itf) {
		for (String Class : this.classes) {
			String ClassName = Class.replace(".", "");
			String ownerName = owner.replace("/", "");
			if (ClassName.equals(ownerName)) {
				if (ClassName
						.equals(currentClass.getClassName().replace("/", ""))) {
					MethodContainer innerCall = new MethodContainer();
					innerCall.setInstantiation(false);
					innerCall.setGoingFromClass(this.currentClass.getClassName());
					innerCall.setGoingToClass(owner);
					innerCall.setGoingToMethod(name);
					innerCall.setDesc(desc);
					this.currentMethod.addInnerCall(innerCall);
					return;
				}
				IRelation relation = new UsesRelation();
				relation.setFromObject(currentClass.getClassName());
				relation.setToObject(owner);
				model.addRelation(relation);
			}
		}
		
		MethodContainer innerCall = new MethodContainer();
		innerCall.setInstantiation(false);
		innerCall.setGoingFromClass(this.currentClass.getClassName());
		innerCall.setGoingToClass(owner);
		innerCall.setGoingToMethod(name);
		innerCall.setDesc(desc);
		this.currentMethod.addInnerCall(innerCall);
	}

	@Override
	public void visitTypeInsn(int opcode, String type) {
		super.visitTypeInsn(opcode, type);
		
		MethodContainer innerCall = new MethodContainer();
		innerCall.setInstantiation(true);
		innerCall.setGoingFromClass(this.currentClass.getClassName());
		innerCall.setGoingToClass(type);
		this.currentMethod.addInnerCall(innerCall);
		
	}

	@Override
	public void visitVarInsn(int opcode, int var) {
		super.visitVarInsn(opcode, var);
	}

}
