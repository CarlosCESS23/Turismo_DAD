# Projeto RMI — Pacote de Turismo

## Objetivo

Criar um sistema distribuído em Java utilizando **RMI (Remote Method Invocation)**, permitindo que diferentes aplicações se comuniquem mesmo quando estiverem executando em máquinas distintas.

A proposta consiste em desenvolver uma aplicação principal responsável por consultar informações disponibilizadas por diferentes servidores remotos.

O sistema será composto pelos seguintes componentes:

- Pacote Turismo;
- Casa;
- Hotel;
- Passagem Aérea;
- Seguro Viagem.

Cada componente secundário será responsável por armazenar e disponibilizar seus próprios dados, enquanto o componente **Pacote Turismo** será responsável apenas por realizar consultas e reunir as informações retornadas pelos demais serviços.

---

# 1. Aplicação Principal — Pacote Turismo

## Descrição

O **Pacote Turismo** será o componente principal da aplicação.

Sua função será atuar como **cliente RMI/orquestrador**, realizando consultas aos serviços remotos responsáveis por Casa, Hotel, Passagem Aérea e Seguro Viagem.

Esse componente **não deverá armazenar os dados pertencentes aos demais serviços**.

Sua responsabilidade será localizar os serviços através do RMI Registry, utilizar suas interfaces remotas e reunir os resultados das consultas.

## Informações

- **Nome da aplicação:** Pacote Turismo
- **Tipo:** Aplicação principal / Cliente RMI
- **Dependências:**
  - Casa;
  - Hotel;
  - Passagem Aérea;
  - Seguro Viagem.
- **Responsabilidade:** Consultar os demais componentes e consolidar as informações retornadas.
- **Armazenamento de dados:** Não será responsável pelo armazenamento dos dados dos componentes secundários.
- **Prazo de entrega:** 10/09/2026

## Informações do Pacote

O Pacote Turismo deverá apresentar informações como:

| Atributo |
|---|
| Origem |
| Destino |
| Hospedagem |
| Passagem Aérea |
| Seguro Viagem |

## Fluxo esperado

```text
                     PACOTE TURISMO
                      Cliente RMI
                           |
          +----------------+----------------+
          |                |                |
          v                v                v
        Casa             Hotel       Passagem Aérea
          |
          +-------------------------------+
                                          |
                                          v
                                   Seguro Viagem
```

O Pacote Turismo deverá consultar cada serviço e utilizar as informações retornadas para formar o resultado final do pacote.

---

# 2. Aplicações Secundárias

As aplicações secundárias funcionarão como **servidores RMI independentes**.

Cada aplicação será responsável por:

1. armazenar seus próprios dados;
2. implementar sua regra de consulta;
3. disponibilizar uma interface remota;
4. registrar seu serviço no RMI Registry;
5. receber requisições da aplicação Pacote Turismo;
6. retornar os dados solicitados.

Os servidores secundários não devem depender diretamente uns dos outros.

---

# 2.1. Casa

## Descrição

O componente **Casa** será responsável por disponibilizar informações relacionadas às casas disponíveis para hospedagem.

Os dados ficarão sob responsabilidade deste servidor e poderão ser consultados remotamente pelo Pacote Turismo.

## Informações

- **Nome da aplicação:** Casa
- **Tipo:** Servidor RMI
- **Dependência de componentes:** Nenhuma
- **Responsabilidade:** Armazenar e disponibilizar dados de casas para consulta.
- **Consumidor principal:** Pacote Turismo
- **Prazo de entrega:** 10/09/2026

## Atributos

| Atributo |
|---|
| Nome |
| Local |
| Custo |

Exemplo:

```text
Nome: Casa Beira-Mar
Local: Fortaleza
Custo: R$ 250,00 por diária
```

---

# 2.2. Hotel

## Descrição

O componente **Hotel** será responsável por armazenar e disponibilizar informações relacionadas aos hotéis disponíveis.

A aplicação Pacote Turismo poderá realizar consultas remotamente através da interface RMI disponibilizada pelo servidor.

## Informações

- **Nome da aplicação:** Hotel
- **Tipo:** Servidor RMI
- **Dependência de componentes:** Nenhuma
- **Responsabilidade:** Armazenar e disponibilizar dados de hotéis para consulta.
- **Consumidor principal:** Pacote Turismo
- **Prazo de entrega:** 10/09/2026

## Atributos

| Atributo |
|---|
| Nome |
| Estado/Local |
| Diária |

Exemplo:

```text
Nome: Hotel Fortaleza
Estado: Ceará
Diária: R$ 230,00
```

---

# 2.3. Passagem Aérea

## Descrição

O componente **Passagem Aérea** será responsável por armazenar e disponibilizar informações relacionadas às rotas aéreas disponíveis.

O Pacote Turismo poderá consultar o serviço informando uma origem e um destino.

## Informações

- **Nome da aplicação:** Passagem Aérea
- **Tipo:** Servidor RMI
- **Dependência de componentes:** Nenhuma
- **Responsabilidade:** Armazenar e disponibilizar informações de passagens aéreas.
- **Consumidor principal:** Pacote Turismo
- **Prazo de entrega:** 10/09/2026

## Atributos

| Atributo |
|---|
| Origem |
| Destino |
| Preço |

Exemplo:

```text
Origem: MAO
Destino: FOR
Preço: R$ 1.000,00
```

---

# 2.4. Seguro Viagem

## Descrição

O componente **Seguro Viagem** será responsável por armazenar e disponibilizar informações relacionadas aos seguros disponíveis para determinada localidade ou destino.

## Informações

- **Nome da aplicação:** Seguro Viagem
- **Tipo:** Servidor RMI
- **Dependência de componentes:** Nenhuma
- **Responsabilidade:** Armazenar e disponibilizar informações de seguro viagem.
- **Consumidor principal:** Pacote Turismo
- **Prazo de entrega:** 10/09/2026

## Atributos

| Atributo |
|---|
| Local/Estado |
| Valor da diária |

Exemplo:

```text
Local: Fortaleza
Valor da diária: R$ 10,00
```

---

# 3. Responsabilidade de cada componente

| Componente | Tipo | Armazena dados? | Realiza consultas remotas? |
|---|---|---:|---:|
| Pacote Turismo | Cliente RMI / Orquestrador | Não | Sim |
| Casa | Servidor RMI | Sim | Não |
| Hotel | Servidor RMI | Sim | Não |
| Passagem Aérea | Servidor RMI | Sim | Não |
| Seguro Viagem | Servidor RMI | Sim | Não |

---

# 4. Comunicação entre os componentes

O fluxo básico será:

```text
Usuário
   |
   v
Pacote Turismo
   |
   +---- consulta ----> Servidor Casa
   |
   +---- consulta ----> Servidor Hotel
   |
   +---- consulta ----> Servidor Passagem Aérea
   |
   +---- consulta ----> Servidor Seguro Viagem
   |
   v
Consolidação dos resultados
   |
   v
Resultado do Pacote
```

Cada servidor deverá disponibilizar uma **interface remota**, que será compartilhada com o cliente Pacote Turismo.

Exemplo conceitual:

```java
public interface IHotelService extends Remote {

    Hotel consultarHotel(String local)
        throws RemoteException;
}
```

O servidor terá a implementação concreta:

```java
public class HotelServiceImpl
        extends UnicastRemoteObject
        implements IHotelService {
}
```

Enquanto o Pacote Turismo utilizará apenas a interface:

```java
IHotelService hotelService;
```

Dessa forma, o Pacote Turismo não precisa conhecer diretamente a implementação interna do servidor.

---

# 5. Resultado esperado

Ao solicitar um pacote com:

```text
Origem: MAO
Destino: FOR
```

o componente principal poderá realizar consultas como:

```text
Passagem Aérea
MAO → FOR
R$ 1.000,00

Hotel
Hotel Fortaleza
R$ 230,00 / diária

Casa
Casa Beira-Mar
R$ 250,00 / diária

Seguro Viagem
Fortaleza
R$ 10,00 / diária
```

E apresentar essas informações de maneira consolidada ao usuário.

---

# Observação Arquitetural

Para fins de documentação técnica, o componente **Pacote Turismo** é melhor descrito como **cliente RMI/orquestrador**, pois sua principal responsabilidade é consumir os serviços remotos e consolidar os resultados.

Já os componentes **Casa, Hotel, Passagem Aérea e Seguro Viagem** funcionam como **servidores RMI**, pois armazenam os dados e disponibilizam operações remotas para consulta.
