package codility.Lesson11;

import java.util.ArrayList;
import java.util.List;

public class CountSemiprimes {

    /**
     * 각 쿼리별 semiprime 수를 반환
     *
     * @param N : 26
     * @param P : [1,4,16]
     * @param Q : [26,10,20]
     *
     * semiprime 일부 : 4, 6, 9, 10, 14, 15, 21, 22, 25, 26
     *
     * 1 ≤ P[K] ≤ Q[K] ≤ N
     *
     * 1) 1 .. 26 => 4, 6, 9, 10, 14, 15 ,21, 22, 25, 26 : 10개
     * 2) 4 .. 10 => 4, 6, 9 10 : 4개
     * 3) 16 .. 20 => 없음 : 0개
     *
     * @return [10,4,0]
     */
    public int[] solution(int N, int[] P, int[] Q) {

        //1.소수 구하기 (에라토스테네스의 체)
        List<Integer> primes = getPrimeByEratos(N);

        //2.반 소수 구하기
        int[] semiPrimes = getSemiPrime(primes, N);

        //3.반 소수 누적합 처리
        for(int i=1; i<semiPrimes.length; i++) {
            semiPrimes[i] += semiPrimes[i-1];
        }

        int[] result = new int[P.length];
        for(int i=0; i<P.length; i++) {
            int p = P[i], q = Q[i];
            result[i] = semiPrimes[q] - semiPrimes[p - 1];
        }

        return result;
    }

    private int[] getSemiPrime(List<Integer> primes, int N) {

        int[] semiPrimes = new int[N + 1];

        for(int prime1 : primes) {

            for(int prime2 : primes) {

                //쿼리의 범위는 N 이하이므로 N보다 큰 반 소수는 구하지 않음
                if(prime1 * prime2 > N) break;

                semiPrimes[prime1 * prime2] = 1;
                //System.out.println(prime1 + " * " + prime2 + " : semiPrime => " + (prime1 * prime2));
            }

        }

        return semiPrimes;
    }

    private List<Integer> getPrimeByEratos(int N) {

        List<Integer> primeList = new ArrayList<>();
        boolean[] primes = new boolean[N + 1];

        primes[0] = false;
        primes[1] = false;

        for(int i=2; i<primes.length; i++) {
            primes[i] = true;
        }

        for (int i=2; i<primes.length; i++) {

            if (primes[i]) {
                primeList.add(i);

                for(int j=i*i; j<primes.length; j+=i) {
                    primes[j] = false;
                }
            }
        }

        //System.out.println("primeList = " + primeList);
        return primeList;
    }

}
