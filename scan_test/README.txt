1. 실습파일 생성(redis 컨테이너 내부에서 실행)
> for i in {0000000..9999999}; do echo set key$i $i >> redis-strings.txt; done

2. 실습파일 실행
> cat redis-strings.txt | redis-cli --pipe

3. REDIS latency 확인
> redis-cli --latency

4. KEYS 실행
KEYS * 실행해서 latency 확인

5. SCAN 실행
SCAN 0 MATCH * COUNT 100
// 성능이 빠름





