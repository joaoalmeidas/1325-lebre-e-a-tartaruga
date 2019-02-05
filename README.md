# 1325-lebre-e-a-tartaruga
Produza uma versão gráfica da simulação da lebre e tartaruga (Questão 7.28). Simule a montanha desenhando
um arco que se estende do canto inferior esquerdo da janela ao canto superior direito. A lebre e a tartaruga devem correr subindo a montanha. Implemente a saída gráfica para imprimir a tartaruga e a lebre no arco a cada movimento. [Dica: estenda o percurso da corrida de
70 para 300 a fim de permitir uma área gráfica maior.]

Exercicio 7.28 do livro Java: Como Programar

(Simulação: a tartaruga e a lebre) Neste problema, você recriará a clássica corrida da tartaruga e da lebre. Você utilizará geração de números aleatórios para desenvolver uma simulação desse evento memorável. Nossos competidores começam a corrida no quadrado 1 de 70 quadrados. Cada um representa uma possível posição ao longo do percurso da competição. A linha de chegada está no quadrado 70. O primeiro competidor a alcançar ou passar o quadrado 70 é recompensado com um cesto de cenouras frescas e alface. O percurso envolve subir uma montanha escorregadia, por isso, ocasionalmente os competidores perdem terreno. Um relógio emite um tique por segundo. A cada tique-taque do relógio, seu aplicativo deve ajustar a posição dos animais de acordo com as regras na Figura 7.32. Use variáveis para monitorar as posições dos animais (isto é, os números de posição são 1 a 70). Inicie cada animal na posição 1 (a "largada"). Se um animal escorregar para a esquerda do quadrado 1, mova-o novamente para o quadrado 1.

Tartaruga

tipo de movimento % do tempo movimento

Caminhada rápida 50% 3 quadrados à direita

Escorregão 20% 6 quadrados à esquerda

Caminhada lenta 30% 1 quadrado à direita

Lebre

tipo de movimento % do tempo movimento

Dormir 20% Sem nenhum movimento

Salto grande 20% 9 quadrados à direita

Escorregão grande 10% 12 quadrados à esquerda

Salto pequeno 30% 1 quadrado à direita

Escorregão pequeno 20% 2 quadrados à esquerda

Gere as porcentagens na Figura 7.32 produzindo um inteiro aleatório i no intervalo 1 d i d 10. Para a tartaruga, realize uma “caminhada rápida” quando 1 d i d 5, um “escorregão” quando 6 d i d 7 ou uma “caminhada lenta” quando 8 d i d 10. Utilize uma técnica semelhante para mover a lebre. Comece a corrida exibindo BANG !!!!! E LÁ VÃO ELES !!!!! Então, para cada tique do relógio (isto é, para cada repetição de um loop), exiba uma linha de 70 posições mostrando a letra T na posi- ção da tartaruga e a letra H na posição da lebre. Ocasionalmente, os competidores ocuparão o mesmo quadrado. Nesse caso, a tartaruga morde a lebre e seu aplicativo deve exibir AI!!! começando nessa posição. Todas as outras posições da saída diferentes de T, H ou AI!!! (no caso de um empate) devem estar em branco. Depois de cada linha ser exibida, teste se o animal alcançou ou passou o quadrado 70. Se tiver alcançado, exiba o vencedor e termine a simulação. Se a tartaruga ganhar, exiba A TARTARUGA VENCEU!!! ÊH!!! Se a lebre ganhar, exiba A LEBRE GANHOU. OH. Se os dois ganharem na mesma hora, você pode querer favorecer a tartaruga (a "coitadinha") ou exibir OCORREU UM EMPATE. Se nenhum animal ganhar, realize o loop novamente para simular o próximo tique do relógio. Quando você estiver pronto para executar seu aplicativo, monte um grupo de fãs para observar a corrida. Você se surpreenderá com a empolgação da sua audiência! Mais adiante no livro, introduziremos várias capacidades do Java, como gráficos, imagens, animação, som e multithreading. À medida que estudar esses recursos, você pode se divertir aprimorando sua simulação da competição entre a lebre e a tartaruga.
