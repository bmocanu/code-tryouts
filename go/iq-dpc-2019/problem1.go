package kata

func RemovNb(m uint64) [][2]uint64 {

	var result = make([][2]uint64)
	var sum = m * (m + 1) / 2;

	for id:= 1; id < m; id++ {


	}

	for (long id1 = 2; id1 < n/2; id1++) {
		long id2 = (sum - id1) / (id1 + 1);
		if (id2 <= n && id1 * id2 == (sum - id1 - id2)) {
			result.add(new long[]{id1, id2});
		}
	}

	return result;


	// your code
}