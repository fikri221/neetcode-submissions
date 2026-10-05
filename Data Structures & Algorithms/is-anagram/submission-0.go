func isAnagram(s string, t string) bool {
    if len(s) != len(t) {
        return false
    }

    // 1. Konversi string ke []rune
	runesS := []rune(s)
    runesT := []rune(t)

    // 2. Sorting menggunakan sort.Slice
	sort.Slice(runesS, func(i, j int) bool {
		return runesS[i] < runesS[j] // Urutan ascending
	})

	sort.Slice(runesT, func(i, j int) bool {
		return runesT[i] < runesT[j] // Urutan ascending
	})

    for i := range runesS {
        if runesS[i] != runesT[i] {
            return false
        }
    }
    return true;
}
