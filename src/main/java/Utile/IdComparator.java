package Utile;

import java.util.Comparator;

import com.roberta.model.Capitol;

public class IdComparator implements Comparator<Capitol> {

	public int compare(Capitol c1, Capitol c2) {
		return c1.getIdCapitol().compareTo(c2.getIdCapitol());
	}

}
