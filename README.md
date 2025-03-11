# Histórias em Microsserviços

Projeto demonstrando comunicação entre microsserviços para composição de histórias distribuídas.

## Visão Geral do Projeto
- **3 grupos de serviços** independentes (G1, G2, G3)
- Cada grupo mantém partes específicas das histórias
- O serviço G3 é responsável por:
    - Fornecer suas partes das histórias
    - Agregar partes de outros serviços para montar histórias completas

## Endpoints

### Partes Individuais (G3)
`GET` `/api/historia/{numero-parte}`
- Retorna apenas a parte mantida pelo G3

| História | Endpoint          | Conteúdo                                      |
|----------|-------------------|----------------------------------------------|
| 1        | `/api/historia/1` | "como ele é um gato, não teve nada."         |
| 2        | `/api/historia/2` | "conheceram o professor de Sistemas Distribuídos" |
| 3        | `/api/historia/3` | "O estagiário chegou às 08 horas da manhã"   |

- Resposta esperada
```json
{ 
  "historia": "como ele é um gato, não teve nada."
}
```

### Histórias Completas
`GET` `/api/historia/{numero-historia}/completa`
- Retorna a história completa combinando partes de todos os serviços

| História | Endpoint               | Composição                                   |
|----------|------------------------|----------------------------------------------|
| 1        | `/api/historia/1/completa` | G1 + G2 + G3                         |
| 2        | `/api/historia/2/completa` | G2 + G3 + G1                         |
| 3        | `/api/historia/3/completa` | G3 + G1 + G2                         |

- Resposta esperada
```json
{
  "historia": "O gato subiu no telhado e depois caiu no chão de uma queda, como ele é um gato, não teve nada."
}
```