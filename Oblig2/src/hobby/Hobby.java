package hobby;

public class Hobby {

	private String hobbyNavn;

	public String getHobbyNavn() {
		return hobbyNavn;
	}

	public Hobby(String hobby) {
		hobbyNavn = hobby;
	}

	@Override
	public String toString() {
		String str = "<" + hobbyNavn + ">";
		return str;
	}

	@Override
	public boolean equals(Object hobby2) {
		if (this == hobby2)
			return true;
		if (hobby2 == null)
			return false;
		if (getClass() != hobby2.getClass())
			return false;
		Hobby hobbyDenAndre = (Hobby) hobby2;
		return (hobbyNavn.equals(hobbyDenAndre.getHobbyNavn()));
	}

}
