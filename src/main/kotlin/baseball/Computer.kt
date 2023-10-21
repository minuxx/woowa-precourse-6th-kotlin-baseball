package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer : Player<Unit> {
    private lateinit var numbers: List<Int>

    /**
     * @param input 사용자로부터의 입력 문자열 (선택적)
     * @param testNumbers testNumbers 테스트 목적으로 제공된 정수 리스트 (선택적)
     * @throws IllegalArgumentException 유효성 검사 실패 시 발생
     */
    override fun generateNumbers(input: String, testNumbers: List<Int>) {
        val generatedNumbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, NUMBER_COUNT)

        if (Validator.areInvalidCountNumbers(generatedNumbers)) {
            throw IllegalArgumentException("수의 개수가 올바르지 않습니다.")
        }

        if (Validator.areOutOfRangeNumbers(generatedNumbers)) {
            throw IllegalArgumentException("수의 범위가 잘못되었습니다.")
        }

        if (Validator.areDuplicateNumbers(generatedNumbers)) {
            throw IllegalArgumentException("중복된 수가 있습니다.")
        }

        numbers = generatedNumbers
    }
}