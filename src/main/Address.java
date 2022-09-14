package main;

public class Address {
	private String label;
	private String address;

	public String getLabel() {
		return label;
	}

	public String getAddress() {
		return address;
	}

	public void setLabel(String label) throws LengthException {
		if (label.length() != 0 && label.length() <= 255) {
			this.label = label;
		} else {
			throw new LengthException("Invalid Label, length should be in the range of (1..255)");
		}
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return label + " Address:" + address + " ";
	}

}
