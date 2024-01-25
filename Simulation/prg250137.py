def solution(bandage, health, attacks):
    answer = health

    last_attack, _ = attacks[-1]
    bandage_sec, recovery_amount, add_recovery = bandage
    attack_idx = 0
    continuity = 0

    for i in range(last_attack + 1):
        attack_sec, attack_damage = attacks[attack_idx]
        if attack_sec == i:
            continuity = 0
            answer -= attack_damage
            if answer <= 0:
                return -1
            attack_idx += 1
        else:
            answer += recovery_amount
            continuity += 1
            if continuity == bandage_sec:
                answer += add_recovery
                continuity = 0

            # 최대 체력을 초과할 수 없음
        answer = min(answer, health)

    return answer
