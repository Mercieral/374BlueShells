package problem.asm;

/**
 * Used for keeping easier track of values belonging to Class values
 * 
 * @author gateslm
 *
 */
public enum EClassAccess implements IAccessFlags {
	ACC_PUBLIC(0x0001), ACC_PRIVATE(0x0002), ACC_PROTECTED(0x0004), ACC_FINAL(
			0x0010), ACC_SUPER(0x0020), ACC_INTERFACE(0x0200), ACC_ABSTRACT(
					0x0400), ACC_SYNTHETIC(0x1000), ACC_ANNOTATION(
							0x2000), ACC_ENUM(0x4000);

	private int accessFlag;

	private EClassAccess(int accessCode) {
		this.accessFlag = accessCode;
	}

	@Override
	public int getAccessFlags() {
		return this.accessFlag;
	}

}